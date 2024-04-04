package Ch39_PROJECTS_2023.Spotify음악조회;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;

public class C01SpotifyApiMain {
	public static void main(String[] args) {
		 // 클라이언트 ID 및 클라이언트 시크릿 설정
        String clientId = "37813def98ee4472b4552c0d2f0241b5";
        String clientSecret = "4b7368768b36468d80019de62cee9ca5";
  

        // 액세스 토큰 얻기
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final var clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            // Artist_ID아티스트 정보 가져오기
            GetArtistRequest getArtistRequest = spotifyApi.getArtist("0TnOYISbd1XYRBk9myaseg").build();
            Artist artist = getArtistRequest.execute();

            
            
            // 아티스트 정보 출력
            System.out.println("Artist Name: " + artist.getName());
            System.out.println("Genres: " + String.join(", ", artist.getGenres()));
            System.out.println("Popularity: " + artist.getPopularity());

            
            
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        
		
	}

}
