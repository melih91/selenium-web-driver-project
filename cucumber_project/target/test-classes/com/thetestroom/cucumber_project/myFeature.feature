@Feature_File
Feature: Smugmug Fotograf Paylasim Sitesinde Fotograf Paylasimi

@Scenario
Scenario: Smugmug Fotograf Paylasim Sitesinde Fotograf Paylasimi

Given Smugmug WebSitesine Gidilir
When Login Sayfasına Gidilir
And  Kullanici adi ve Sifre Girilir
Then Fotograf Paylasim Ekranina Gidilir
And  Fotograf Yuklenir.
Then Fotograf Yukleme Basarili Sekilde Gerceklesmistir.