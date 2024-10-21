package org.example;

import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;

import java.text.MessageFormat;

public final class Main {

    public static void main(String[] args) {
        try {
            String apiKey = MyAPI.API_KEY;
            String fileUrl = "https://github.com/AkbharChowdhury/AudioTranscribe/raw/refs/heads/main/src/main/java/org/example/Thirsty.mp4";
            var client = AssemblyAI.builder().apiKey(apiKey).build();

            var transcriptParams = TranscriptParams.builder().audioUrl(fileUrl).speakerLabels(true).build();

            var transcript = client.transcripts().transcribe(transcriptParams);

            transcript.getUtterances().ifPresent(i -> i.forEach(speaker -> System.out.println(MessageFormat.format("Speaker {0}: {1}", speaker.getSpeaker(), speaker.getText()))));

            System.out.println(transcript.getText());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


    }
}
