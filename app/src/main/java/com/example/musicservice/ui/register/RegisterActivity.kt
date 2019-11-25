package com.example.musicservice.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.ui.login.LoginActivity
import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.presenter.RegisterPresenter
import com.example.musicservice.ui.client.ClientDetailsFormActivity
import kotlinx.android.synthetic.main.activity_registration.*

class RegisterActivity : AppCompatActivity(), RegisterContract.RegisterView{


    private val presenter : RegisterPresenter = component.registerPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        presenter.setView(this)
        setAllActivityComponents()
    }

    private fun setAllActivityComponents() {
        sign_up_registration.setOnClickListener{
            presenter.onSignUpButtonClicked(
                input_email_registration.text.toString(),
                input_password_registration.text.toString(),
                input_username_registration.text.toString())
        }
        sign_in_text_registration.setOnClickListener{
            presenter.onSignInButtonClicked()
        }

        user_type_check_box_registration.setOnClickListener{
            if(user_type_check_box_registration.isChecked) presenter.onCheckboxUsed("musicprovider")
            else presenter.onCheckboxUsed("client")
        }
    }

    override fun showUsernameError() {
        input_username_registration.error = getString(R.string.username_error)
        input_username_registration.requestFocus()
    }

    override fun onClientRegisterSuccess() {
        startActivity(getIntentStartingNewActivityStack(ClientDetailsFormActivity::class.java))
    }

    override fun onMusicProviderRegisterSuccess() {
/*      todo
        startActivity(getIntentStartingNewActivityStack(ClientDetailsFormActivity::class.java))
*/
    }

    private fun <T> getIntentStartingNewActivityStack(classType : Class<T>) : Intent{
        var intent = Intent(this, classType)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return intent
    }

    override fun showPasswordError() {
        input_password_registration.error = getString(R.string.password_error)
        input_password_registration.requestFocus()
    }

    override fun showEmailError() {
        input_email_registration.error = getString(R.string.email_error)
        input_password_registration.requestFocus()
    }
    override fun onDelegateToLogin() = startActivity(Intent(this, LoginActivity::class.java))
    override fun onFailRegistration() = Toast.makeText(this,R.string.registration_failed,Toast.LENGTH_SHORT).show()
    override fun showProgressBar() {
        progress_bar_registration.visibility = View.VISIBLE
    }
    override fun hideProgressBar() {
        progress_bar_registration.visibility = View.GONE
    }

}