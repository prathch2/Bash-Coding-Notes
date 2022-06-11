package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;
import java.util.List;
import java.util.ArrayList;

public class SortingLab {

    public static void main(String[] args) {
        Bridges bridges = new Bridges(3, "EDWINSC12", "1487706376901");

        DataSource ds = bridges.getDataSource();

        List<ActorMovieIMDB> movieData = null;

        try {

            movieData = ds.getActorMovieIMDBData(Integer.MAX_VALUE);

        } catch (Exception e) {

            System.out.println("Unable to connect to Bridges.");

        }

        for(int i = 0; i < 5; i++) {

            ActorMovieIMDB entry = movieData.get(i);

            System.out.println("" + i + ".  " + entry.getActor() + " was in " + entry.getMovie());
        }


        ArrayList<ActorMovieIMDB> filteredMovieList = new ArrayList<>();
        for(ActorMovieIMDB actor : movieData){
            if(actor.getMovie().equals("Being_John_Malkovich_(1999)"))
                filteredMovieList.add(actor);
        }

        ActorMovieIMDB actor1 = movieData.get(1);
        ActorMovieIMDB actor2 = movieData.get(2);

        ActorComparator actorComparator =  new ActorComparator();

        filteredMovieList.sort(actorComparator);
        actorComparator.compare(actor1,actor2);

        for(ActorMovieIMDB actorMovieIMDB : filteredMovieList){
            System.out.println(actorMovieIMDB.getActor());
        }
        
        }

    }

