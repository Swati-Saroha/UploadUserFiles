package scaffold

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MyScaffoldSpec extends Specification implements DomainUnitTest<MyScaffold> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
