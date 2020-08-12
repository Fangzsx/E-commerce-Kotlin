package com.functions
import com.accounts.Account
import com.tools.Helper
import com.transaction.CheckOut
import com.transaction.Product
import com.userinfo.Profile
import java.sql.Date
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Menu{


    fun welcomePage(){
        println("                           $$$$")
        println("                         $      $")
        println("                        $        $")
        println("                      $$$$$$$$$$$$$$")
        println("                      $$$$$$$$$$$$$$")
        println("                      $$$\$SHOPPE$$$$")
        println("                      $$$$$$$$$$$$$$")
        println("                      $$$$$$$$$$$$$$")
        println("\n                   L O A D I N G . . .")
    }

    fun display(){
        println("Login Successfully!\n")
        println("\nShopipi-pipi-pipipi!")
        println("Welcome User!")
        println("Date: ${LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)}")

        println("[1] Shop Now!")
        println("[2] My Cart")
        println("[3] Check Out")
        println("[4] My Profile")
        println("[5] Log-out")
        print("Select: ")
        when (Helper.selectionListener()){
            1 -> viewAllProducts()
            2 -> viewCart()
            3 -> pay()
            4 -> Profile.view()
            5 -> logout()
        }
    }

    private fun logout(){
        println("Successfully Log-out.")
    }

    // view all existing products
    private fun viewAllProducts(){
        println("Shop Now!\n")
        println("Choose an item you wish to View")
        var counter = 1
        for (product in CheckOut.productList){
            println("[$counter] ${product.name}")
            counter++

        }
        print("Select: ")
        when(Helper.selectionListener()) {
            1 -> viewProductSpecs(1)
            2 -> viewProductSpecs(2)
            3 -> viewProductSpecs(3)
        }
    }

    // view current product description with option to add the current item to cart
    private fun viewProductSpecs(index : Int){
        val getProduct : Product = CheckOut.productList[index-1]

        // display product's name first, followed by the specs

        println("Now Viewing . . .")

        println("Product ID: ${getProduct.id}")
        println("Product name: ${getProduct.name}")
        println("Specs: ${getProduct.specs}")
        println("Price: ${getProduct.price}")
        println("Add To Cart? [1] YES   [0] NO ")
        print("Select: ")
        if (Helper.selectionListener() == 1) {
            CheckOut.cart.add(getProduct)
            println("${getProduct.name} was successfully added to cart!\n")
        }
        println("Going back to Main Menu")
        print("Enter any key to Continue")
        readLine()
        display()
    }

    private fun viewCart(){
        var subTotal = 0.0
        println("\nYour Cart")
        if (CheckOut.cart.isEmpty()) {
            println("Cart is empty!")
            println("Shop Now? ")
            println("[1] YES   [0] NO")
            if (readLine()!!.toInt() == 1){
                viewAllProducts()
            }
            else display()
        }
        for (item in CheckOut.cart){
            println("Product id: ${item.id}")
            println("Product name: ${item.name}")
            println("Product price: ${item.price}\n")
            subTotal += item.price
        }
        println("Total Amount Due: P$subTotal")
        println("Do you want to Check out?")
        println("[1] YES   [0] NO, Go back to Main Menu")
        print("Select: ")
        if (Helper.selectionListener() == 1)
            pay()
        else display()
    }

    private fun pay(){

        println("\nSHOPIPIPI-PIPIPI Purchase Order")
        println("Please confirm your order. . \n")
        val tax = 0.12
        var subTotal = 0.0

        //get sum of all products added to cart
        for (product in CheckOut.cart){
            println("Product id: ${product.id}")
            println("Product name: ${product.name}")
            println("Product price: ${product.price}\n")
            subTotal+=product.price
        }
        // add 12% tax
        println(message = "VAT: ${subTotal * tax}")
        println("VATable Sale: $subTotal")
        subTotal += (subTotal * tax)
        println("Total: $subTotal")
        var shippingMethod = getShippingMethod()
        if (shippingMethod == ShippingMethod.CASHONDELIVERY && !Profile.getAddress().isNullOrEmpty()){
            println("Success! Your order(s) will be shipped in ${Profile.getAddress()}")
        }
        else {
            println("Finish setting up your address first!")
            print("Address: ")
            Profile.setAddress(readLine()!!.toString())
            println("Your order(s) will be shipped in ${Profile.getAddress()}")
        }
    }
    private fun getShippingMethod(): ShippingMethod? {
        println("Choose your Shipping Method from the following")
        println("[1] Cash-on-Delivery")
        println("[2] Cash-on-Pickup")
        println("[3] Online-Bank-Payment")
        print("Select: ")
        val code = Helper.selectionListener()
        for (method in ShippingMethod.values())
            if (method.ordinal == code-1)
                return method
        return null
    }

    enum class ShippingMethod {
        CASHONDELIVERY,
        CASHONPICKUP,
        ONLINEBANKPAYMENT
    }
}
