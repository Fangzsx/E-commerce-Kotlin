package com.userinfo

import com.functions.Menu
import com.tools.Helper

object Profile{
    private var firstName : String? = null
    private var lastName : String? = null
    private var address : String? = null
    private var phoneNumber : String? = null
    private var email :  String? = null

    private fun setFullName(firstName : String, lastName : String){
        Profile.firstName = firstName
        Profile.lastName = lastName
    }
    private fun getFirstName() = firstName
    private fun getLastNme() = lastName
    fun setAddress(address : String){
        Profile.address = address
    }
    fun getAddress() = address

    private fun setPhoneNumber(phoneNumber : String){
        Profile.phoneNumber = phoneNumber
    }
    private fun getPhoneNumber() = phoneNumber

    private fun setEmail(email : String){
        Profile.email = email
    }
    private fun getEmail() = email

    fun set(){
        println("\nSet your Profile")
        print("First Name: ")
        val firstName : String  = readLine()!!.toString().trim()
        print("Last Name: ")
        val lastName : String = readLine()!!.toString().trim()
        setFullName(firstName, lastName)
        print("Address: ")
        setAddress(readLine()!!.toString())
        print("Contact Number: ")
        setPhoneNumber(readLine()!!.toString())
        print("Email: ")
        setEmail(readLine()!!.toString().trim())
        println("Your profile was updated!")
        print("Press enter to continue . . ")
        readLine()
        Menu.display()
    }
    fun view(){

        // check if profile's property is not empty or null
        if(getFirstName()
                .isNullOrEmpty() || getLastNme()
                .isNullOrEmpty()|| getAddress()
                .isNullOrEmpty() || getEmail()
                .isNullOrEmpty() || getPhoneNumber().isNullOrEmpty()) {
            println("Profile is not yet set!")
            set()
            println("Returning to Main Menu . . .")
            print("Press enter to continue . . .")
            readLine()
            Menu.display()
        }

        else{
            println("Your Profile")
            println("Full name: ${getFirstName()} ${getLastNme()}")
            println("Address: ${getAddress()}")
            println("Phone Number: ${getPhoneNumber()}")
            println("Email: ${getEmail()}")
            println("Update Profile?")
            println("[1] YES   [0] NO, Go back to Main Menu")
            if (Helper.selectionListener() == 1)
                set()
            else Menu.display()
        }
    }
}