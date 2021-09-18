package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.network.ApiService
import com.example.playground.ui.theme.PlaygroundTheme
import com.example.playground.network.RetrofitClientInstance.retrofitInstance
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service: ApiService = retrofitInstance!!.create(
            ApiService::class.java
        )
        runBlocking {
            service.uploadFileSimple(
                uploadUrl = "https://banter-videos.s3.amazonaws.com/video5.mp4?AWSAccessKeyId=ASIA3MNZRCZ76PIUFI75&Signature=UkEthlyIs5bfEw0Vfzsw330a2RQ%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEFcaCXVzLWVhc3QtMSJHMEUCIAGJOsE%2Fuvg4AVk6BmwLucioYt%2B8rtwQGNlyed4t3AjvAiEA%2FdYFS0h4kDWaPkbIXxTkzN8C1cYrhhxh25HeCd06ZyAqmQIIr%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgw3ODI2MTAwMTE3NzUiDKEMFIf5%2Bz0tbWUC6CrtAZSFxNp%2FKoAKepbFM9CunN2DeO83wdU5U30xehDTn03pxm2%2FR%2FYvPPAy%2FQI4OhwSVCSPSqnzfwo30z4T%2ByfbC82SxLxiZzN%2BRziNH9GHJvtM28kQ6Fq01R3dj36VZ3qDJbRf%2FL9vbpwhem71HLUPtylE5PuAJk%2FfA2JcPMHlqyjj9UiyKXVWXazWsoBexpW%2BRdrlKLtjLhlsbKqU1f8i5%2Fs8AJGF9tID9PB%2BdZz9VxWKTrgu3rsMMnGNKrmDAq4%2BP0%2BEmODUOpe3RJCENwKKAwrBaLvPjfsUADOESF%2B41UV2dnNWcQEObUtF78viLDCNxZmKBjqaAZ7lOqLHiTZtOu01tmqV1JT2ObWiHHNRk5ed7OKiy%2FEh2G%2F23O0mApH8jPjgEEE91DWjSTt6AKYzofrSc%2Fe%2Bdlor0ENmd5hJehv0hW61MWGIHzikUqq1ZeRHqKZUhKFjO%2FERPaYbp0OGamuxNrKmWXPXJVjiuQ6Sdluk3MEA%2FX2klsuV7xKU0tAsKiOVzXKVP%2FhRMBUDOWAzxLc%3D&Expires=1632006712"
            )
        }

        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundTheme {
        Greeting("Android")
    }
}
