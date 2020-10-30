#!/usr/bin/env ruby
require 'httparty'
require 'nokogiri'
require 'json'

class Tool
  def initialize
    set_cookie
  end

  def auto_register
    start_id_arr = File.read('startId').split
    start_id = start_id_arr[0].to_i

    loop do
      num_interval_invalid = 0
      while be_valid_id(start_id) || (num_interval_invalid < 10) do
        if !be_valid_id(start_id)
          num_interval_invalid = num_interval_invalid.next

          puts "ID:  #{start_id} is invalid"
        else
          num_interval_invalid = 0

          if can_register(start_id)
            req = HTTParty.post('https://abettervietnam.org/student/dangky', {:body => {'_token' => @@auth_token, 'id' => start_id}, headers: {'Cookie' => @@cookie_hash.to_cookie_string}})
            puts req.body
          else
            puts "ID:  #{start_id} can not register"
          end
        end
        start_id = start_id.next
      end
      start_id = start_id - num_interval_invalid
      puts 'sleeping 5 minutes'
      sleep(300)
    end
  end

  def set_cookie
    get_login_response = HTTParty.get('https://abettervietnam.org/login')
    noko_doc = Nokogiri::HTML(get_login_response)
    @@auth_token = noko_doc.css('form').css('input').first.values[2]

    @@cookie_hash = HTTParty::CookieHash.new
    get_login_response.get_fields('Set-cookie').each { |c| @@cookie_hash.add_cookies(c) }

    login_info_data = File.read('loginInfo').split
    params = {'_token' => @@auth_token, 'email' => login_info_data[0], 'password' => login_info_data[1]}
    post_login_response = HTTParty.post('https://abettervietnam.org/login', {:body => params, headers: {'Cookie' => @@cookie_hash.to_cookie_string}})
    post_login_response.get_fields('Set-Cookie').each { |c| @@cookie_hash.add_cookies(c) }
  end

  def can_register(id)
    time_register_data = File.read('registerTime').split
    teacher_name_data = File.readlines('teacherName', chomp: true)
    start_time = time_register_data[0]
    end_time = time_register_data[1]
    req_get_calendar = HTTParty.get('https://abettervietnam.org/student/laylich/'+id.to_s, {headers: {'Cookie' => @@cookie_hash.to_cookie_string}})
    res = JSON.parse(req_get_calendar.body)
    res_time = res['ngay_bat_dau'].split[1]
    res_teacher_name = res['lich']['giao_vien']['name']
    res_student_id = res['lich']['lich_hoc_viens']

    return (res_time >= start_time) && (res_time <= end_time) && (teacher_name_data.include?(res_teacher_name)) && (res_student_id.length == 0)
  end

  def be_valid_id(id)
    req_get_calendar = HTTParty.get('https://abettervietnam.org/student/laylich/'+id.to_s, {headers: {'Cookie' => @@cookie_hash.to_cookie_string}})
    return req_get_calendar.code != 500
  end
end

# initialize object and run auto
Tool.new.auto_register
