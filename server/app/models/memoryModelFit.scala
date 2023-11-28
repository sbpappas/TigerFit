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

    def updateDays(username: String, days: Int): Boolean = {
        userInfo(username)._4 = days
        true
    }

    def updateFitnessGoal(username: String, goal: String): Boolean = {
        userInfo(username)._3 = goal
        true
    }

    def updateHeight(username: String, newHeight: Int): Boolean = {
        userInfo(username)._2 = newHeight
        true
    }

    def updateWeight(username: String, newWeight: Int): Boolean = {
        userInfo(username)._1 = newWeight
        true
    }

    def retrieveWorkoutByDate(username: String, date: String): Workout { //need to make a workout class?

    }

    /*retrieveWorkoutById(id: Int): Workout
    retrieveAllWorkouts(username: String): Collection[Workout]
    retrieveCompletedWorkouts(username: String): Collection[Date]
    retrieveUnfinishedWorkouts(username: String): Collection[Date]
    markWorkoutComplete(username: String, id: Int): Boolean

    searchExercises(username: String, labels: Collection[String]): Collection[Exercise]
    retrieveExercise(id: Int): Exercise*/


    
}