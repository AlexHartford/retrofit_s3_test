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
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.InputStream


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service: ApiService = retrofitInstance!!.create(
            ApiService::class.java
        )

        val `in`: InputStream = resources.openRawResource(R.raw.alextest)
        val buf = ByteArray(`in`.available())
        val requestBody: RequestBody =
            buf.toRequestBody(null, 0, buf.size)
        runBlocking {
            service.uploadFile(
                uploadUrl = "https://banter-videos.s3.amazonaws.com/alextest.mp4?AWSAccessKeyId=ASIA3MNZRCZ7XKZQKGX6&Signature=DYaSAyJdwQYrnO3YShkqA5mGIv4%3D&x-amz-security-token=IQoJb3JpZ2luX2VjEGYaCXVzLWVhc3QtMSJGMEQCIBGXDuQz2bMI3mmWx6I092yCr4LSno8nLQL7XDWN7UFOAiBTuROcJal63RFLkBlxEgHkUNk%2FEtHmgC0cspLt80jLryqZAgi%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDc4MjYxMDAxMTc3NSIMqL2Z8QT2d4hCfwvlKu0Bi8WwQp49aoL7e2UqbiL5TIVfSZtA9icBWY9Pj737%2FkVX8m8UPtM7l6n9uDWEFFvUVi0uN%2FktyGyVatVYnFx2sFv7qHNSzNDh1XcqPWnV1GTuKa0PaoLqhmWfD88Q7Jv1aGHkoRgDuFwV6RgyDgW5WNgriM%2BV1aC886Ljf5W%2BWABs6Uir0JPIMc3GCS2vMx4FTYG6VauKQKttSQVwpiouDJgnfrZ2ZRRXKLGTMuZkJh4J9Xlup9O5IlcBPqE%2FSkaIG%2FriydByfVt1u2z5s7oNK5fbqDB66RF%2B4vF3RbApRIr%2BKAFxn8YF0qS3pw78MMv7nIoGOpsBXH4hCtPcEDuoZg9ZNIUh%2FZI%2B9dWLDgP%2BJsCCposfbnwnwWT94CTtHDCdshD6b5Wty%2FgTc3W1%2BMBDTHcmAs%2BHH%2B8O8BlUIOV0EI4rmMm6W0zTF3ZCpsHL929WQuo%2Bz0PUlzYkue4QOz3vgA%2FuSlnhw7pYxjzy5AB3GN0A%2FE2j311fhViTzQ5tM1lLKqIGjFNSRg5sX7GKi6Tw0hI%3D&Expires=1632062429",
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
