package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK

class NoteController {

    def index() {
        [noteList:Note.list()]
    }

    def create() {
        respond new Note()
    }


    def save(Note note) {
        if (note == null) {
            notFound()
            return
        }

        note.save()

        if(note.hasErrors()){
            flash.errors = note.errors.allErrors.collect { [message: g.message([error: it])] }
            respond note, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'note.label', default: 'Note'), [note.message]])
                redirect note
            }
            '*' { respond note, [status: CREATED] }
        }
    }

    def edit(Note note) {
        if (note == null) {
            notFound()
            return
        }

        respond note
    }

    def show(Note note) {
        respond note
    }

    def update(Note note) {
        if (note == null) {
            notFound()
            return
        }

        note.save(flush:true)

        if(note.hasErrors()){
            flash.errors = note.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'note.label', default: 'Note'), [note.message]])
                redirect note
            }
            '*' { respond note, [status: OK] }
        }
    }

    def delete(Note note) {
        if (note == null) {
            notFound()
            return
        }
        def noteMessage = note.message
        note.delete(flush: true)

        if(note.hasErrors()){
            flash.errors = note.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'note.label', default: 'Note'), [noteMessage]])
                redirect  action: "index", method: "GET"
            }
            '*' { respond note, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'note.label', default: 'Note'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
