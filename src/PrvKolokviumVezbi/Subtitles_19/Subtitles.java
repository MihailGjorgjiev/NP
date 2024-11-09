package PrvKolokviumVezbi.Subtitles_19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Subtitles {
    private List<SubtitleLog> subtitles;

    public Subtitles() {
        this.subtitles=new ArrayList<>();
    }

    public int loadSubtitles(InputStream in) throws IOException {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(in))){
           while (true){
               String id= reader.readLine();
               if(id == null){
                   break;
               }
               String timestamp=reader.readLine();
               String comment="";
               while (true){
                   String commentSection=reader.readLine();
                   if(commentSection == null){
                       break;
                   }
                   if(commentSection.isEmpty()){
                       break;
                   }
                   comment+=commentSection+"\n";
               }
               subtitles.add(new SubtitleLog(Integer.parseInt(id),timestamp,comment));
           }

        }
        return subtitles.size();
    }


    public void print() throws IOException {
//        try (BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out))){
//            for (SubtitleLog log:subtitles){
//                writer.write(log.toString());
//                writer.flush();
//            }
//            writer.flush();
//        }
        for (SubtitleLog log:subtitles){
            System.out.println(log);
        }
    }

    public void shift(int shift) {
        for(SubtitleLog log:subtitles){
            log.shift(shift);
        }
    }
}