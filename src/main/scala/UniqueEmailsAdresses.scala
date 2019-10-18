object Solution {
  def numUniqueEmails(emails: Array[String]): Int = {
    val res = emails.map(email => {
    val emailSplit = email.split("@")
    val local = emailSplit(0)
    val domain = emailSplit(1)
    val localNew = local.replace(".", "");
    val localRes = localNew.split("\\+")(0)
    localRes + "@" + domain
    })
    res.distinct.length
  }
  def main(args: Array[String]): Unit = {
    val emails = Array("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    println(numUniqueEmails(emails))
  }
}