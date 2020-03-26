{
"id" : ${person.id},
"first_name" : "${person.first_name}",
"last_name" : "${person.last_name}",
"addresses" : [<@render partial="address" collection=person.getAddresses() spacer="comma"/> ]
}