package kg.kmn.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var expressionTV: TextView
    private lateinit var resultTV: TextView
    private var expressText = ""
    private lateinit var e: Expression
    private var countParentheses = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expressionTV = findViewById(R.id.tv_expression)
        resultTV = findViewById(R.id.tv_result)

    }

    fun onClickEqual(view: View) {
        if (expressionTV.text.toString().isNotEmpty()) {
            expressText = expressionTV.text.toString()

            try {
                e = ExpressionBuilder(expressText).build()
                resultTV.text = e.evaluate().toString()

            } catch (e: ArithmeticException) {
                Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_LONG).show()
            } catch (exc: Exception) {
                Toast.makeText(this, "Correct and enter again, please.", Toast.LENGTH_LONG).show()
            }


        }
    }


    fun onClickAC(view: View) {
        expressionTV.text = ""
        resultTV.text = ""
    }

    fun onClickLeftParenthesis(view: View) {
        countParentheses++
        expressionTV.text = expressionTV.text.toString() + "("
    }

    fun onClickRightParenthesis(view: View) {
        countParentheses--
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + ")"
    }

    fun onClickDividing(view: View) {
        eraseIfLastIsArithOperation()
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + "/"
    }

    fun onClickMultiplication(view: View) {
        eraseIfLastIsArithOperation()
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + "*"
    }

    fun onClickSubtraction(view: View) {
        eraseIfLastIsArithOperation()
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + "-"
    }

    fun onClickPoint(view: View) {
        eraseIfLastIsArithOperation()
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + "."
    }

    fun onClickAdding(view: View) {
        eraseIfLastIsArithOperation()
        if (expressionTV.text.isNotEmpty())
            expressionTV.text = expressionTV.text.toString() + "+"
    }

    fun onClickBack(view: View) {
        if (expressionTV.text.toString().isNotEmpty()) {
            val temp = expressionTV.text.toString()
            expressionTV.text = temp.substring(0, temp.length - 1)
        }

        resultTV.text = ""
    }

    fun onClickNum0(view: View) {
        expressionTV.text = expressionTV.text.toString() + "0"
    }

    fun onClickNum1(view: View) {
        expressionTV.text = expressionTV.text.toString() + "1"
    }

    fun onClickNum2(view: View) {
        expressionTV.text = expressionTV.text.toString() + "2"
    }

    fun onClickNum3(view: View) {
        expressionTV.text = expressionTV.text.toString() + "3"
    }

    fun onClickNum4(view: View) {
        expressionTV.text = expressionTV.text.toString() + "4"
    }

    fun onClickNum5(view: View) {
        expressionTV.text = expressionTV.text.toString() + "5"
    }

    fun onClickNum6(view: View) {
        expressionTV.text = expressionTV.text.toString() + "6"
    }

    fun onClickNum7(view: View) {
        expressionTV.text = expressionTV.text.toString() + "7"
    }

    fun onClickNum8(view: View) {
        expressionTV.text = expressionTV.text.toString() + "8"
    }

    fun onClickNum9(view: View) {
        expressionTV.text = expressionTV.text.toString() + "9"
    }

    fun eraseIfLastIsArithOperation() {
        if (expressionTV.text.isNotEmpty()) {
            val temp = expressionTV.text.toString()
            val last = temp.substring(temp.length - 1, temp.length)
            if (last == "+" || last == "-" || last == "*" || last == "/" || last == ".") {
                expressionTV.text = temp.substring(0, temp.length - 1)
            }
        }
    }
}
