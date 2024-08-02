package br.com.matheusv.happy_birthday_letter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.matheusv.happy_birthday_letter.ui.theme.HappyBirthdayLetterTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {                                     // Código onde ficará o contéudo final
            HappyBirthdayLetterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF8A2BE2)
                )
                {
                 GreetingImage(
                        message = stringResource(R.string.happy_birthday_jason),  //Utiliza-se "stringResource" para reutilizar Strings
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.padding(2.dp)
                    )
                }
                }
            }
        }
    }

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center,        //Centralizar a saudação
        modifier = modifier) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(40.dp)
                .align(alignment = Alignment.End)
        )
        }
    }

//Imagem de fundo

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.4F
        )
        GreetingText(message = message, from = from,modifier = Modifier
            .fillMaxSize()
            .padding(10.dp) )
    }
}


//Prévia de como ficará o layout

@Preview(name = "My Birthday Letter", showSystemUi = true, showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayLetterTheme{
        GreetingText(message = "Happy Birthday Jason!!", from = "From Matheus")
    }
}
