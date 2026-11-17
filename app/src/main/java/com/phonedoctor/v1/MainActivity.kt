
package com.phonedoctor.v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PhoneDoctorApp()
            }
        }
    }
}

@Composable
fun PhoneDoctorApp() {
    var resultado by remember {
        mutableStateOf("Escolha uma opção para começar.")
    }

    val testes = listOf(
        "Informações do dispositivo",
        "Verificação da bateria",
        "Teste de som",
        "Teste do ecrã",
        "Verificação de armazenamento"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "PhoneDoctor",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Diagnóstico de telemóveis",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Ferramentas de diagnóstico",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            testes.forEach { teste ->
                Button(
                    onClick = {
                        resultado = when (teste) {
                            "Informações do dispositivo" ->
                                "Consulta as informações do teu telemóvel nas definições do Android."

                            "Verificação da bateria" ->
                                "Consulta o estado e o consumo da bateria nas definições."

                            "Teste de som" ->
                                "Reproduz um áudio para verificar o funcionamento do altifalante."

                            "Teste do ecrã" ->
                                "Verifica visualmente o ecrã, o brilho e a resposta ao toque."

                            else ->
                                "Consulta o espaço disponível nas definições de armazenamento."
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                ) {
                    Text(teste)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = resultado,
                    modifier = Modifier.padding(18.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Proprietário: Piedade Muachico",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Contacto: freepiedade@gmail.com",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Versão 1.0.0",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
