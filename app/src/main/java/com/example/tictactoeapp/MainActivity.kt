package com.example.tictactoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Reset(view: View){
        finish()
        startActivity(this.intent)
        overridePendingTransition(0,0)
    }

    fun Enabelbu(){

        bu1.isEnabled = false
        bu2.isEnabled = false
        bu3.isEnabled = false
        bu4.isEnabled = false
        bu5.isEnabled = false
        bu6.isEnabled = false
        bu7.isEnabled = false
        bu8.isEnabled = false
        bu9.isEnabled = false
    }

    fun ClickBu(view: View) {

    val buSelected = view as Button

        var cellId = 0
        when(buSelected.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        PlayGame(cellId,buSelected)
    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun PlayGame(cellId:Int, buSelected:Button){

        if( activePlayer == 1){
            buSelected.text = "X"
            buSelected.setTextSize(50F)
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
        }else{
            buSelected.text = "O"
            buSelected.setTextSize(50F)
            buSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false

        checkWinner()
    }

   fun checkWinner(){

       var winer = -1

       // row 1
       if( player1.contains(1) && player1.contains(2) && player1.contains(3) ){
           winer = 1
       }
       if( player2.contains(1) && player2.contains(2) && player2.contains(3) ){
           winer = 2
       }

       // row 2
       if( player1.contains(4) && player1.contains(5) && player1.contains(6) ){
           winer = 1
       }
       if( player2.contains(4) && player2.contains(5) && player2.contains(6) ){
           winer = 2
       }

       // row 3
       if( player1.contains(7) && player1.contains(8) && player1.contains(9) ){
           winer = 1
       }
       if( player2.contains(7) && player2.contains(8) && player2.contains(9) ){
           winer = 2
       }

       // col 1
       if( player1.contains(7) && player1.contains(4) && player1.contains(1) ){
           winer = 1
       }
       if( player2.contains(7) && player2.contains(4) && player2.contains(1) ){
           winer = 2
       }

       // col 2
       if( player1.contains(8) && player1.contains(5) && player1.contains(2) ){
           winer = 1
       }
       if( player2.contains(8) && player2.contains(5) && player2.contains(2) ){
           winer = 2
       }

       // col 3
       if( player1.contains(9) && player1.contains(6) && player1.contains(3) ){
           winer = 1
       }
       if( player2.contains(9) && player2.contains(6) && player2.contains(3) ){
           winer = 2
       }


       // diag 1
       if( player1.contains(1) && player1.contains(5) && player1.contains(3) ){
           winer = 1
       }
       if( player2.contains(1) && player2.contains(5) && player2.contains(3) ){
           winer = 2
       }

       // diag 2
       if( player1.contains(9) && player1.contains(5) && player1.contains(1) ){
           winer = 1
       }
       if( player2.contains(9) && player2.contains(5) && player2.contains(1) ){
           winer = 2
       }

       if( winer == 1 ){
           Enabelbu()
           Toast.makeText(this, "Player 1 win ",Toast.LENGTH_LONG).show()
           result.text = "Player 1 win "
       }else if ( winer == 2 ){
           Enabelbu()
           Toast.makeText(this, "Player 2 win ",Toast.LENGTH_LONG).show()
           result.text = "Player 2 win "
       }



   }
}