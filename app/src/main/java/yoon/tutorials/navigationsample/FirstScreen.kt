package yoon.tutorials.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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

@Composable
// Unit객체 반환하는 람다함수를 매개변수로 가지는 FirstScreen 함수
// navigateToSecondScreen - SecondScreen으로 이동하는 함수
// FirstScreen은 TextField에 입력된 name 값을 저장하고, Button을 클릭하면 SecondScreen으로 이동
fun FirstScreen(navigateToSecondScreen: (name:String) -> Unit) {
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
        // onClick 이벤트는 SecondScreen으로 이동하는 navigateToSecondScreen함수를 호출
        Button(onClick = {
            // name.value에 입력된 값을 저장
            // name.value에 입력된 값이 빈문자열일 경우 "no name"을 저장
            val nameToPass = name.value.ifEmpty { "no name" }
            navigateToSecondScreen(nameToPass)
            // navigationToSecondScreen을 호출하여 SecondScreen으로 이동
            // name.value에 입력된 값을 전달
        }) {
            // Button의 Text를 설정
            // Text는 버튼에 표시되는 텍스트를 설정
            Text(text = "Go to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    NavigationSampleTheme {
        // FirstScreen 함수를 호출하여 화면에 표시
        // FirstScreen은 navigationToSecondScreen을 매개변수로 가짐
        // FirstScreen은 navigationToSecondScreen을 호출하여 SecondScreen으로 이동
        // 빈 람다함수를 매개변수로 전달
        FirstScreen (navigateToSecondScreen = {})
    }
}
