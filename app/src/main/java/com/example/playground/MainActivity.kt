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
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service: ApiService = retrofitInstance!!.create(
            ApiService::class.java
        )

        val `in`: InputStream = resources.openRawResource(R.raw.alextest4)
//        val buf = ByteArray(`in`.available())
//
//        val requestBody: RequestBody =
//            buf.toRequestBody(null, 0, buf.size)

        val file = File(cacheDir, "test.mp4")

        copyStreamToFile(`in`, file)

        val requestBody: RequestBody = file.asRequestBody(null)

        runBlocking {
            service.uploadFile(
                uploadUrl = "https://banter-videos.s3.amazonaws.com/alextest5.mp4?AWSAccessKeyId=ASIA3MNZRCZ7Q5P3O75M&Signature=CMrUR%2BzNsaDNPj6G%2BzmB9ped2hs%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEG0aCXVzLWVhc3QtMSJHMEUCIQCfAw%2BHJTfIGmbOEbv2tW6D1e5t1kSQrnyS1tsemySKHwIgJAUfTurj0sfnfNfiMPJHJtA%2FAzYJs5pUfclbszdS09AqmQIIxf%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgw3ODI2MTAwMTE3NzUiDJE%2Bof%2BlnmppVto9AyrtAVEYWFIUje1Ib9deeY0d0sI%2FiIDFspXKrnilNXlGceXnycsUmSsnXcNrvQfWlVqYojbxoSEb%2BlV2yDUQhg9%2FSCPl5h3fgdsbkR3nBsjEcY66SaVTfI2jTRHshna1x2317pV2gNp2QlVe1qHN1K1yv8Ut4CH7SwxFMBD8bq27W13LmiJFohqKTOg%2FypuPUrB%2F6SESy7KkZYu%2BBgjTV%2FhaO06ugjv02blQ2iMvmdk71CPlmZ%2BNvq4xo0dqNtWHxhi8Zov%2F1W03pUdCslt0q%2B8HBsPtEYGARBYGt3P8YMlGI9LSIUHrKlNzsCQqwMghCTDQsp6KBjqaAZApc6I6XWuYeiKn3jebbuV4FQz2zNhV%2FiWohr8%2FvhAx0CzXsf%2BNf2xrOX90GEV2D08WLa2WaKd9LgNj%2FgFxT2lCOv9BGmJe%2FlDG0XYKZRsub4wB2PfyOsg%2FsVOzDlmTRPCuW2bKFsBpVnb2U6%2FFzvuNqz8bpWeGdVeP9N6rSp7nMi4BkS0EtAqUBChin0i1IAxIEaFsqQQTVa0%3D&Expires=1632085858",
                file = requestBody
            )
        }

        // send with no body
//        runBlocking {
//            service.uploadFileSimple(
//                uploadUrl = "https://banter-videos.s3.amazonaws.com/video5.mp4?AWSAccessKeyId=ASIA3MNZRCZ76PIUFI75&Signature=UkEthlyIs5bfEw0Vfzsw330a2RQ%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEFcaCXVzLWVhc3QtMSJHMEUCIAGJOsE%2Fuvg4AVk6BmwLucioYt%2B8rtwQGNlyed4t3AjvAiEA%2FdYFS0h4kDWaPkbIXxTkzN8C1cYrhhxh25HeCd06ZyAqmQIIr%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgw3ODI2MTAwMTE3NzUiDKEMFIf5%2Bz0tbWUC6CrtAZSFxNp%2FKoAKepbFM9CunN2DeO83wdU5U30xehDTn03pxm2%2FR%2FYvPPAy%2FQI4OhwSVCSPSqnzfwo30z4T%2ByfbC82SxLxiZzN%2BRziNH9GHJvtM28kQ6Fq01R3dj36VZ3qDJbRf%2FL9vbpwhem71HLUPtylE5PuAJk%2FfA2JcPMHlqyjj9UiyKXVWXazWsoBexpW%2BRdrlKLtjLhlsbKqU1f8i5%2Fs8AJGF9tID9PB%2BdZz9VxWKTrgu3rsMMnGNKrmDAq4%2BP0%2BEmODUOpe3RJCENwKKAwrBaLvPjfsUADOESF%2B41UV2dnNWcQEObUtF78viLDCNxZmKBjqaAZ7lOqLHiTZtOu01tmqV1JT2ObWiHHNRk5ed7OKiy%2FEh2G%2F23O0mApH8jPjgEEE91DWjSTt6AKYzofrSc%2Fe%2Bdlor0ENmd5hJehv0hW61MWGIHzikUqq1ZeRHqKZUhKFjO%2FERPaYbp0OGamuxNrKmWXPXJVjiuQ6Sdluk3MEA%2FX2klsuV7xKU0tAsKiOVzXKVP%2FhRMBUDOWAzxLc%3D&Expires=1632006712"
//            )
//        }

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

fun copyStreamToFile(inputStream: InputStream, outputFile: File) {
    inputStream.use { input ->
        val outputStream = FileOutputStream(outputFile)
        outputStream.use { output ->
            val buffer = ByteArray(4 * 1024) // buffer size
            while (true) {
                val byteCount = input.read(buffer)
                if (byteCount < 0) break
                output.write(buffer, 0, byteCount)
            }
            output.flush()
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
