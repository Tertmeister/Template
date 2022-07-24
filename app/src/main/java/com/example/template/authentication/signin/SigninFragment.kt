package com.example.template.authentication.signin

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.template.R

class SigninFragment : Fragment() {

    companion object {
        fun newInstance() = SigninFragment()
    }

    private lateinit var viewModel: SigninViewModel
    private lateinit var mSigninButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view= inflater.inflate(R.layout.sign_in_fragment, container, false)
        mSigninButton=view.findViewById(R.id.sign_in_btn)

        view.findViewById<EditText>(R.id.email_et).addTextChangedListener {
          it?.let {
              viewModel.updateEmail(it.trim().toString())
              it.trim().toString()
          }
        }
        view.findViewById<EditText>(R.id.password_et).addTextChangedListener {
            it?.let {
                viewModel.updatePassword(it.trim().toString())
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SigninViewModel::class.java)

        viewModel.isSignInButtonEnabled.observe(viewLifecycleOwner) {
            mSigninButton.isEnabled = it
        }
    }
}