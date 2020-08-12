package com.transaction

//static list for storing products added to cart
object CheckOut{
    var cart = mutableListOf<Product>()
    var productList = listOf(
        Asus(),
        Samsung(),
        Xiaomi()
    )

    // pass "this" to add the current product to cart
    fun addToCart(product : Product ,cart : MutableList<Product>){
        cart.add(product)
    }
}

abstract class Product{

    abstract var name :  String
    abstract var id :  String
    abstract var price : Double
    abstract var specs : String


}



interface Laptop {
    var productType : String
}

interface Phone {
    var productType : String
}

interface Tablet {
    var productType : String
}


class Asus : Product(),Laptop{
    override var productType: String = "Laptop"
    override var name: String = "Asus i5 6th Gen"
    override var id: String = "0100-ASUSI5-6THGEN"
    override var price: Double = 22_000.0
    override var specs = "RAM : 12 GB / VC : NVIDIA 920M / Storage : 1 TB HDD"


}

class Xiaomi : Product(),Phone{
    override var productType: String = "Mobile Phone"
    override var name: String = "Xiaomi Mi 9T"
    override var id: String = "0200XIAOMI9T-6128"
    override var price: Double = 18_000.0
    override var specs = "RAM : 6 GB / Storage : 128 GB / SUPER AMOLED DISPLAY"
}

class Samsung : Product(), Tablet{
    override var productType = "Tablet"
    override var name: String = "Samsung Tab X-series"
    override var id: String = "0300SAMSUNG-3/32"
    override var price : Double = 10_000.00
    override var specs = "RAM : 3 GB / Storage : 32 GB / Dual-Sim Enabled"
}