package models

import collection.mutable

object memoryModelFit{
    private var userPass = mutable.Map[String, String]("samc" -> "drowssap", "setho" -> "password", "oliviab" -> "123", "samuelp"-> " ") 
    private val goals = Seq[String] ("Gain Muscle", "Lose Weight", "Stay Healthy")
    private var userInfo = mutable.Map[String, Tuple4[Int, Int, String, Int]]("samc" -> Tuple4(180, 72, goals(0), 4))
     

    def validateUser(username: String, password: String): Boolean = {
        userPass.get(username).map(_ == password).getOrElse(false)
    }

    def createUser(username: String, password: String): Boolean = {
        if (userPass.contains(username)) false else{
            userPass(username) = password
            true
        }
    }

    def updatePassword(username: String, oldPass: String, newPass: String): Boolean = {
        if (validateUser(username, oldPass) == true) {
            userPass(username) = newPass 
            true
        }
        else false
    }


    // def updateWeight(username: String, newWeight: String): Boolean = {
    //     userInfo(username)._1 = newWeight
    //     true
    // }
    
}