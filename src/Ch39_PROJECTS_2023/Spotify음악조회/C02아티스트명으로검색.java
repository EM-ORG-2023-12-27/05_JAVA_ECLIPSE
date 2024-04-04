package Ch39_PROJECTS_2023.Spotify음악조회;

import java.io.IOException;
import java.text.ParseException;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

public class C02아티스트명으로검색 {

	public static void main(String[] args) throws Exception {
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

            // 아티스트 검색하기
            String artistName = "Beyonce";
            SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(artistName).build();
            Paging<Artist> searchResult = searchArtistsRequest.execute();
            
            System.out.println(searchResult);

            
            		
            		
            // 검색 결과에서 첫 번째 아티스트 정보 가져오기
//            Paging<Artist> artistPaging = searchResult.getArtists();
//            Artist[] artists = artistPaging.getItems();
//            if (artists.length > 0) {
//                Artist artist = artists[0];
//                // 아티스트 정보 출력
//                System.out.println("Artist Name: " + artist.getName());
//                System.out.println("Genres: " + String.join(", ", artist.getGenres()));
//                System.out.println("Popularity: " + artist.getPopularity());
//            } else {
//                System.out.println("Artist not found.");
//            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
		
	}
}
