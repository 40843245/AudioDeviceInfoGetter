package com.jay30.audiodeviceinfogetter

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.media.AudioAttributes
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jay30.audiodeviceinfogetter.ui.theme.AudioDeviceInfoGetterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AudioDeviceInfoGetterTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main(){
    val audioAttributesBuilder = AudioAttributes.Builder()
    val audioAttributes = audioAttributesBuilder
        .setUsage(AudioAttributes.USAGE_MEDIA)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()
    AudioDeviceInfoScreen(
        LocalContext.current,
        audioAttributes,
    )
}

@Composable
fun AudioDeviceInfoScreen(
    currentContext: Context,
    audioAttributes: AudioAttributes,
){
    val NO_SUCH_AUDIO_DEVICE = "No such audio device"

    val audioManager = currentContext.getSystemService(AUDIO_SERVICE) as AudioManager
    val audioDevicesInfo = audioManager.getAudioDevicesForAttributes(audioAttributes)
    val firstAudioDeviceInfo : AudioDeviceInfo? = audioDevicesInfo.firstOrNull()

    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        innerPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(verticalScrollState)
            .horizontalScroll(horizontalScrollState),
    ){
        Text("firstAudioDeviceInfo.isSink:${firstAudioDeviceInfo?.isSink ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.isSource:${firstAudioDeviceInfo?.isSource ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.id:${firstAudioDeviceInfo?.id ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.address:${firstAudioDeviceInfo?.address ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.productName:${firstAudioDeviceInfo?.productName ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.type:${firstAudioDeviceInfo?.type ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.sampleRates:${firstAudioDeviceInfo?.sampleRates?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.audioDescriptors:${firstAudioDeviceInfo?.audioDescriptors?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.audioProfiles:${firstAudioDeviceInfo?.audioProfiles?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.channelCounts:${firstAudioDeviceInfo?.channelCounts?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.channelIndexMasks:${firstAudioDeviceInfo?.channelIndexMasks?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.channelMasks:${firstAudioDeviceInfo?.channelMasks?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.encodings:${firstAudioDeviceInfo?.encodings?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.encapsulationMetadataTypes:${firstAudioDeviceInfo?.encapsulationMetadataTypes?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
        Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
        Text("firstAudioDeviceInfo.encapsulationMetadataTypes:${firstAudioDeviceInfo?.encapsulationMetadataTypes?.joinToString { "\n" } ?: NO_SUCH_AUDIO_DEVICE }")
    }
        }
}