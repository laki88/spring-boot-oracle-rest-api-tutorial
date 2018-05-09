package com.example.easynotes.service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NotesChecker {

    @Autowired
    NoteRepository noteRepository;


    public Note getNoteById(Long noteId) {
        System.out.println("access from db...................................");
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    public static void main(String[] args) {
        new NotesChecker().getNoteById(1L);
    }

//    @Cacheable(value = "note-single")
    public void test() {
            getNoteById(1L);
    }



}
