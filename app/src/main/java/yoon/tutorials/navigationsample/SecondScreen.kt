package yoon.tutorials.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yoon.tutorials.navigationsample.ui.theme.NavigationSampleTheme

@Composable
// name - FlristScreen화면에서 입력하는 name
// navigateToFirstScreen - FirstScreen으로 이동하는 함수
fun SecondScreen(name: String,navigateToFirstScreen: (name:String) -> Unit) {

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
        Text(text = "This is the second screen", fontSize = 24.sp)
        // Text를 통해 name을 화면에 표시
        Text(text = "Welcome ${name}!", fontSize = 24.sp)
        // Button을 클릭하면 SecondScreen으로 이동
        // Button은 클릭 이벤트를 처리하는 onClick을 가짐
        Button(onClick = {
            // navigationToSecondScreen을 호출하여 SecondScreen으로 이동
            navigateToFirstScreen(name)
        }) {
            // Button의 Text를 설정
            // Text는 버튼에 표시되는 텍스트를 설정
            Text(text = "Go to First Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    NavigationSampleTheme {
        SecondScreen("yoon",navigateToFirstScreen = {})
    }
}
