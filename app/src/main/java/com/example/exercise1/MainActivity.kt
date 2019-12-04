package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            if (carPrice.text.toString().isNotEmpty()&&downPayment.text.toString().isNotEmpty()&&loanPeriod.text.toString().isNotEmpty()&&interestRate.text.toString().isNotEmpty()){
                loanCalculator(it)
            }else{
                Toast.makeText(this, R.string.error_input, Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            resetInput(it)
        }

    }
    private  fun loanCalculator(view: View){
        val df = DecimalFormat("###################.##")
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val carLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest =  findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val carLoanResult:Int = carPrice.text.toString().toInt() - downPayment.text.toString().toInt()
        val interestResult: String = df.format(carLoanResult.toDouble()*(interestRate.text.toString().toDouble()/100)*loanPeriod.text.toString().toDouble())
        val monthlyRepaymentResult:String = df.format((carLoanResult.toDouble()+interestResult.toDouble())/loanPeriod.text.toString().toDouble()/12)

        carLoan.text = "Loan : " + carLoanResult.toString()
        interest.text = "Interest : " + interestResult
        monthlyRepayment.text = "Monthly Repayment : " + monthlyRepaymentResult

    }
    private fun resetInput(view: View){

        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val carLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest =  findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        carPrice.text.clear()
        downPayment.text.clear()
        loanPeriod.text.clear()
        interestRate.text.clear()
        carLoan.text = "Loan :"
        interest.text = "Interest :"
        monthlyRepayment.text = "Monthly Repayment :"
    }
}
