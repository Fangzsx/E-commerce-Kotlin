import com.accounts.User
import com.functions.Menu

fun main(){

    // start page
    Menu.welcomePage()
    // user will log in, create an account if the credentials do not exist
    User.homePage()
    // displays all the functionalities
    Menu.display()


}

