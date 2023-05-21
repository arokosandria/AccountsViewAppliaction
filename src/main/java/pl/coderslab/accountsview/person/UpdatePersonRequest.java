package pl.coderslab.accountsview.person;

public record UpdatePersonRequest(String name,
                                  String lastName,
                                  String email) {
}
