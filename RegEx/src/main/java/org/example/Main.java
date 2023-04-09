package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Tìm những dòng kết thúc bằng games: game$
        //Tìm những nơi có chứa ký tự hoặc a, hoặc b, hoặc c: [abc]
        //Những nơi ko chứa a, hoặc b, hoặc c : [^abc]
        //Những chỗ có ký tự số từ 1-5: [1-5]
        //Chứa chữ game hoặc board: game|board
        //Dòng bắt đầu bằng số và dấu chấm: ^[\d]\.
        //Dòng bắt đầu bằng số và ký tự bất kỳ(0-9, a-z, A-Z): ^[\d].
        //Chữ đầu dòng là số, chữ sau ko phải số: ^[\d][\D]
        //Dấu cách ở cuối dòng: [\s]$
        //Một ký tự bất kỳ, hoa/thường, số : \w
        //Tìm những chỗ có dấu cách xen giữa 2 ký tự: (\w)(\s+)([\w])
        //Tìm các string có dạng địa chỉ email: [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}
        //Lấy ra tên các bộ phim: <li class="item small">(.*?)</li> <div class="name"><span>(.*?)</span></div>

//        RegexExample regexExample = new RegexExample("C:\\Users\\huyho\\Desktop\\JAVA\\inputData.txt");
//        List<String> emails = regexExample.findEmails();
//        emails.forEach(email->{
//            System.out.println("email: "+email);
//        });
//        RegexExample regexExample = new RegexExample("C:\\Users\\huyho\\Desktop\\JAVA\\films.txt");
//        List<String> films = regexExample.findFilmNames();
//        films.forEach(film->{
//            System.out.println("film: "+film);
//        });
        RegexExample regexExample = new RegexExample("C:\\Users\\huyho\\Desktop\\JAVA\\films.txt","https://motchill.tv/");
        List<String> films = regexExample.findFillNameFromURL();
        films.forEach(film->{
            System.out.println("film: "+film);
        });
    }
}