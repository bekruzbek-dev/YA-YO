package uz.yalife.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import uz.yalife.app.ui.YaYoApp
import uz.yalife.app.ui.YaYoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YaYoTheme {
                YaYoApp()
            }
        }
    }
}
