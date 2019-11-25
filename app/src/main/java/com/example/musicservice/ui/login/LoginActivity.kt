package com.example.musicservice.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.ui.client.ClientDetailsFormActivity
import com.example.musicservice.ui.client.ClientMainMenuActivity
import com.example.musicservice.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {


    private val presenter: LoginPresenter = component.loginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.setView(this)
        presenter.initLogOut()
        setAllActivityComponents()
    }

    private fun setAllActivityComponents() {
        sign_in_login.setOnClickListener {
            presenter.onSignInButtonClicked(
                input_email_login.text.toString(),
                input_password_login.text.toString()
            )
        }
        sign_up_login.setOnClickListener {
            presenter.onSignUpButtonClicked()
        }
    }

    override fun showPasswordError() {
        input_password_login.error = getString(R.string.password_error)
    }

    override fun showEmailError() {
        input_email_login.error = getString(R.string.email_error)
    }

    override fun onLoginFailedToast() = Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()


    override fun onMusicProviderLoginSuccess() {
/*      todo
        startActivity(getIntentStartingNewActivityStack(MusicPro))
*/
    }

    override fun onClientLoginSuccess() {
        startActivity(getIntentStartingNewActivityStack(ClientMainMenuActivity::class.java))
    }

    private fun <T> getIntentStartingNewActivityStack(classType : Class<T>) : Intent{
        var intent = Intent(this, classType)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return intent
    }

    override fun delegateToRegistrationActivity() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

}
