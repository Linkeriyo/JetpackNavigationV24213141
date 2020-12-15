package com.example.jetpacknavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.jetpacknavigation.R
import kotlinx.android.synthetic.main.fragment_calculadora.*

class CalculatorFragment : Fragment() {
    private var num1Introduced = false
    private var num1 = 0;
    private var num2 = 0;
    private var resetOnNext = false

    //TODO: va mal
    private fun calculate(num1: Int, num2: Int): Int {
        when (textViewOperator.text) {
            "+" -> {
                val result = num1 + num2
                if (result.toString().length > 8) {
                    return -1
                } else {
                    return result
                }
            }
            "-" -> {
                val result = num1 - num2
                if (result < 0) {
                    return 0
                }
                if (result.toString().length > 8) {
                    return -1;
                } else {
                    return result
                }
            }
            "*" -> {
                val result = num1 * num2
                if (result.toString().length > 8) {
                    return -1
                } else {
                    return result
                }
            }
            "/" -> {
                if (num2 == 0) {
                    textViewNumbers.text = getString(R.string.error)
                    return -1
                }
                val result = num1 / num2
                if (result.toString().length > 8) {
                    return -1
                } else {
                    return result
                }
            }
        }
        return -1
    }

    private fun setButtonListeners() {

        buttonEquals.setOnClickListener {
            var toSend: String
            toSend = getString(R.string.error)
            if (num1Introduced) {
                val text = textViewNumbers.text.toString()
                num2 = Integer.parseInt(text)
                val result = calculate(num1, num2)
                if (result >= 0) {
                    toSend = result.toString()
                }
            }

            val direction = CalculatorFragmentDirections.actionCalculadoraFragmentToResultFragment(toSend)
            it.findNavController().navigate(direction)

        }

        // Adds to string.
        button0.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text != "0" && textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("0")
            resetOnNext = false
        }
        button1.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("1")
            resetOnNext = false
        }
        browseButton.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("2")
            resetOnNext = false
        }
        cameraButton.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("3")
            resetOnNext = false
        }
        calculadoraButton.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("4")
            resetOnNext = false
        }
        button5.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("5")
            resetOnNext = false
        }
        button6.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("6")
            resetOnNext = false
        }
        button7.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("7")
            resetOnNext = false
        }
        button8.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("8")
            resetOnNext = false
        }
        button9.setOnClickListener {
            if (resetOnNext || textViewNumbers.text == getString(R.string.error)) textViewNumbers.text =
                ""
            if (textViewNumbers.text == "0") textViewNumbers.text = ""
            if (textViewNumbers.text.length < 8) textViewNumbers.text =
                textViewNumbers.text.toString().plus("9")
            resetOnNext = false
        }

        //Operators
        buttonPlus.setOnClickListener {
            if (textViewNumbers.text == getString(R.string.error)) {
                textViewNumbers.text = resources.getText(R.string.defaultTextViewValue)
            }
            textViewOperator.text = "+"
            if (!num1Introduced) {
                val text = textViewNumbers.text.toString()
                num1 = Integer.parseInt(text)
                num1Introduced = true
            }
            resetOnNext = true
        }
        buttonMinus.setOnClickListener {
            if (textViewNumbers.text == getString(R.string.error)) {
                textViewNumbers.text = resources.getText(R.string.defaultTextViewValue)
            }
            textViewOperator.text = "-"
            if (!num1Introduced) {
                val text = textViewNumbers.text.toString()
                num1 = Integer.parseInt(text)
                num1Introduced = true
            }
            resetOnNext = true
        }
        buttonMult.setOnClickListener {
            if (textViewNumbers.text == getString(R.string.error)) {
                textViewNumbers.text = resources.getText(R.string.defaultTextViewValue)
            }
            textViewOperator.text = "*"
            if (!num1Introduced) {
                val text = textViewNumbers.text.toString()
                Integer.parseInt(text)
                num1Introduced = true
            }
            resetOnNext = true
        }
        buttonDiv.setOnClickListener {
            if (textViewNumbers.text == getString(R.string.error)) {
                textViewNumbers.text = resources.getText(R.string.defaultTextViewValue)
            }
            textViewOperator.text = "/"
            if (!num1Introduced) {
                val text = textViewNumbers.text.toString()
                Integer.parseInt(text)
                num1Introduced = true
            }
            resetOnNext = true
        }

        //Clear
        buttonClear.setOnClickListener {
            textViewOperator.text = ""
            textViewNumbers.text = resources.getText(R.string.defaultTextViewValue)
            num1Introduced = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonListeners()
    }
}

