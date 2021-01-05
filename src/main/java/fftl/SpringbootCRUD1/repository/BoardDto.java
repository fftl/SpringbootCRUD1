package fftl.SpringbootCRUD1.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String regdate;
    private String writer;

    @Builder
    public BoardDto(Long id, String title, String content, String regdate, String writer){
        this.id = id;
        this.content = content;
        this.regdate = regdate;
        this.title = title;
        this.writer = writer;
    }
}
