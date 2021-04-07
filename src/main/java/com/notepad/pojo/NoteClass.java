package com.notepad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteClass {
    private int note_class_id;
    private String note_class;
    private int note_number;
}
