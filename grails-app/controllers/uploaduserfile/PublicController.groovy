package uploaduserfile

import co.UploadUserFileCO


class PublicController {

    def index() {
        println("Index action......")
        [:]
    }

    def uploadFeaturedImage(UploadUserFileCO cmd) {
        println("Upload image action......")

        if (cmd.hasErrors()) {
            println("Upload image action : has errors......")
            respond(cmd.errors, view: 'index')
            return
        }

        //def src = new File("/home/ongraph/Pictures/pic.png")
        def dst = new File("/home/ongraph/Documents/${cmd.myFile.originalFilename}")
        dst << cmd.myFile.getBytes()
        println(dst)



        redirect(controller: "public" , action:"uploadFeaturedImage")
    }

    def uploadExcel() {
    }
}

