import groovyx.net.http.RESTClient

def accessToken

def facebook = new RESTClient('https://graph.facebook.com/')

def response = facebook.get (
    path: '/v2.7/me',
    query: [ access_token: accessToken, fields: 'id,name,education,work' ]
)

println "Raw response:"
println response.data
println "==========================="

println "Facebook id: ${response.data.id}"
println "Name: ${response.data.name}"
println "==========================="

println "Education:"
response.data.education.each {
    println "---------------------------"
    println "Facebook education id: ${it.id}"
    println "Education type: ${it.type}"
    println "Education name: ${it.school?.name}"
    println "Education year: ${it.year?.name}"
}
println "==========================="

println "Work:"
response.data.work.each {
    println "---------------------------"
    println "Facebook work id: ${it.id}"
    println "Work employer: ${it.employer?.name}"
    println "Work location: ${it.location?.name}"
    println "Work position: ${it.position?.name}"
    println "Work start_date: ${it.start_date}"
}
println "==========================="