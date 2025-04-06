package yoon.tutorials.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    // NavController는 화면 간 이동을 관리하는 컴포넌트
    val navController = rememberNavController()
    // NavHost를 사용하여 화면을 구성
    // NavHost는 화면을 구성하는 컴포넌트로, NavHost 내부에 composable을 추가하여 화면을 구성
    // NavHost는 startDestination을 설정하여 시작 화면을 지정
    // NavHost는 rememberNavController를 사용하여 NavController를 생성
    NavHost(navController = navController, startDestination = "firstscreen") {
        // route 속성값은 구성한 @Composable 함수를 지정
        // route 속성값의 이름은 개발자 임의지정

        // FirstScreen함수를 조작하는 composable함수
        composable(route = "firstscreen") {
            // 만들어둔 FirstScreen을 호출
            // FirstScreen은 navigateToSecondScreen을 매개변수로 가짐
            // FirstScreen은 화면에 name 값을 입력하고 SecondScreen으로 전달하고 이동
            FirstScreen(navigateToSecondScreen = {
                // navigate를 사용하여 화면 이동
                // navigate는 NavController를 사용하여 화면 간 이동을 처리
                // navigate의 인자로 이동할 화면의 route를 전달
                // route는 composable에 설정한 route를 전달
                // secondscreen에 name:String 변수를 참조하여 전달
                name ->
                navController.navigate("secondscreen/$name")
            })
        }
        // SecondScreen함수를 조작하는 composable함수
        // firstscreen에서 입력한 name을 {name}를 통해 받아옴
        composable(route = "secondscreen/{name}") {
            // arguments를 사용하여 route로 전달된 인자를 받아옴
            // getString을 사용하여 String 타입으로 변환
            // name값이 NULL일 경우 "no name"으로 설정해서 전달
            val name = it.arguments?.getString("name") ?: "no name"
            // SecondScreen은 firstscreen에서 입력한 name을 받아오고 화면에 표시
            SecondScreen( name, navigateToFirstScreen = {
                navController.navigate("firstscreen")
            })
        }
    }

}









