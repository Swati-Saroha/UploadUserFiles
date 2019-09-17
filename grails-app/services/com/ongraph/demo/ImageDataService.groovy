package com.ongraph.demo

import grails.gorm.transactions.Transactional

@Transactional
class ImageDataService {

    ImageDataService pointOfInterestDataService

    String cdnFolder
    String cdnRootUrl

    @Override
    void setConfiguration(Config co) {
        cdnFolder = co.getRequiredProperty('grails.guides.cdnFolder')
        cdnRootUrl = co.getRequiredProperty('grails.guides.cdnRootUrl')
    }

    @SuppressWarnings('JavaIoPackageAccess')
    Image uploadFeatureImage(FeaturedImageCommand cmd) {

        println("test")
        String filename = cmd.featuredImageFile.originalFilename
        String folderPath = "${cdnFolder}/image/${cmd.id}"
        File folder = new File(folderPath)
        if ( !folder.exists() ) {
            folder.mkdirs()
        }
        String path = "${folderPath}/${filename}"
        cmd.featuredImageFile.transferTo(new File(path))

        String featuredImageUrl = "${cdnRootUrl}//image/${cmd.id}/${filename}"
        Image image = imageDataService.updateFeaturedImageUrl(cmd.id, cmd.version, featuredImageUrl)

        if ( !image || image.hasErrors() ) {
            File f = new File(path)
            f.delete()
        }
        image
    }
}
