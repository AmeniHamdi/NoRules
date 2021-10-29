/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme.entities;

/**
 *
 * @author Ameni Hamdi
 */
public class NotesTransport {
     private int IdNote;
    private String typeNote ;

    public NotesTransport() {
    }

    public NotesTransport(int IdNote, String typeNote) {
        this.IdNote = IdNote;
        this.typeNote = typeNote;
    }

    public NotesTransport(String typeNote) {
        this.typeNote = typeNote;
    }

    public int getIdNote() {
        return IdNote;
    }

    public void setIdNote(int IdNote) {
        this.IdNote = IdNote;
    }

    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    @Override
    public String toString() {
        return "NotesTransport{" + "IdNote=" + IdNote + ", typeNote=" + typeNote + '}';
    }
    
    
    
    
    
    
}
