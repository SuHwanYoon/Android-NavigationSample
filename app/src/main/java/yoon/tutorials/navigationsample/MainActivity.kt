package yoon.tutorials.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yoon.tutorials.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}


@Composable
fun FirstScreen() {
    val name = remember{
        mutableStateOf("")
    }
    // Column을 사용하여 화면을 구성
    // Column은 세로로 배치되는 요소들을 가질 수 있는 Layout
    // Column은 자식 요소들을 세로로 배치하며, 자식 요소들은 Column의 width를 가짐
    Column(
        // Column을 화면 전체로 채우기
        // padding을 16dp로 설정
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        // Column의 vertical 정렬을 Center로 설정
        verticalArrangement = Arrangement.Center,
        // Column의 horizontal 정렬을 CenterHorizontally로 설정
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the first screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            // name.value에 입력된 값을 저장
            // OutlinedTextField의 onValueChange는 TextField에 입력된 값을 저장
            name.value = it
        })
        // Button을 클릭하면 SecondScreen으로 이동
        // Button은 클릭 이벤트를 처리하는 onClick을 가짐
        Button(onClick = { /*TODO*/ }) {
            // Button의 Text를 설정
            // Text는 버튼에 표시되는 텍스트를 설정
            Text(text = "Got to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    NavigationSampleTheme {
        FirstScreen()
    }
}








