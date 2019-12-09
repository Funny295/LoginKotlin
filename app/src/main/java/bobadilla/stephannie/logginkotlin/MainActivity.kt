package bobadilla.stephannie.logginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar.setOnClickListener{
            val user = etNombre.text.toString()
            val pass = etPass.text.toString()

            if (user.equals("") or pass.equals("")){
                mensaje("Datos vacíos", Toast.LENGTH_LONG)
            }else{
                if (user.equals("stephannie") and pass.equals("1234")){
                    val i = Intent(this, SegundaActivity::class.java)
                    i.putExtra("nombre", "Stephannie")
                    startActivity(i)
                    mensaje("Bienvenido")
                }else{
                    mensaje("No te conozco intruso")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    Log.wtf("Ejemplo", "Debo estar en el onStart")
    }

    fun mensaje(mensaje:String, dur:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this, mensaje, dur).show()
    }
}
