package com.java2nb.novel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Schema(description = "表示一个章节的内容")
public class BookContentVo {
    @Schema(description = "章节id")
    private Long id;
    @Schema(description = "章节id，也叫目录id")
    private Long indexId;
    @Schema(description = "章节内容，主要是中文文本内容，也可能包含部分html标签")
    private String content;
}
