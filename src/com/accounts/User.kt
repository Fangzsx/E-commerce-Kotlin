package com.accounts
import com.tools.Helper

object User{

    fun homePage(){
        println("Welcome to Shoppipiipi-pipi!")
        println("[1] Login")
        println("[0] Sign up")
        print("Select: ")
        if (readLine()!!.toInt() == 1){
            logIn()
        }
        else signUp()
    }

    private fun signUp(){
        println("Sign Up")
        print("New Username: ")
        val newUsername = readLine()!!.toString()
        print("New Password: " )
        val newPassword = readLine()!!.toString()

        Database.registeredAccounts.add(Account(newUsername, newPassword))
        println("Account was successfully created!\n")
        homePage()
    }

    private fun logIn() {

        do{
            println("Login")
            print("Username: ")
            val usernameAttempt : String = readLine()!!.toString()
            print("Password: ")
            val passwordAttempt : String = readLine()!!.toString()
            val tempAccount = Account(usernameAttempt, passwordAttempt)

            if (!Database.registeredAccounts.contains(tempAccount)) {
                println("Account does not Exist!")
                println("Create a new Account?")
                println("[1] YES   [0] NO, Go back to Main Menu")
                print("Select: ")
                if (Helper.selectionListener() == 1)
                    signUp()
                else homePage()
            }
        }while (false)


    }
}