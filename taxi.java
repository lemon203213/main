import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class taxi {
    int taxi_num;//택시 번호
    int basicfee;//기본요금
    int addfee;//추가요금
    int totalfee;//총요금
    boolean start_stop;//손님이 탔나 안탔나 탔으면 f?
    int oil;//기름
    int speed;//속도
    int price;//목적지//얼마 거리 이하 /얼마이상을 넘기면 추가요금으로 측정
    int basicDistance;//기본 거리
    int destinationPrice;//목적지
    Scanner sc = new Scanner(System.in);
}
class new_taxi extends taxi {
    List<Integer> taxilist = new ArrayList<>();

    boolean taxi_num_heck(int taxinum) {
        for (int i = 0; i < taxilist.size(); i++) {
            if (taxinum == taxilist.get(i)) {
                System.out.println("택시번호가 중복됩니다. ");
                System.out.println("-----다른 번호로 등록해주세요.-----");
                return false;
            }
        }
        taxilist.add(taxinum);
        return true;
    }

    new_taxi(int taxi_num, boolean start_stop, int oil, int speed, int price, int basicDistance,int basicfee,int addfee) {
        this.taxi_num = taxi_num;
        this.start_stop = false;//false: 일반상태 true: 운행상태
        this.oil = oil;
        this.speed = speed;
        this.basicfee=basicfee;
        this.addfee=addfee;
        this.basicDistance=basicDistance;


        System.out.println("생성할 택시 번호를 입력해주세요: ");
        taxi_num=sc.nextInt();

        if(!taxi_num_heck(taxi_num)){
            this.taxi_num=sc.nextInt();
        }
        else{
            System.out.println("택시 기본 요금을 입력해주세요: ");
            this.basicfee=sc.nextInt();
            System.out.println("택시 추가 요금를 입력해주세요: ");
            this.addfee=sc.nextInt();
            System.out.println("기본 요금으로 측정될 거리를 입력해주세요: ");
            this.basicDistance=sc.nextInt();
            System.out.println("오일을 입력해주세요: ");
            this.oil=sc.nextInt();
            System.out.println("최고 속도를 입력해주세요: ");
            this.speed=sc.nextInt();
            System.out.println("버스" + taxi_num + "번이 생성 되었습니다.");}
    }


    public boolean passenger() {//승객 태우기
        if (this.start_stop == true) {//운행중
            System.out.println("운행중인 택시입니다.");
            // boolean minus_passenger=false;//손님 하차 할 건가?
            System.out.println("택시에서 하차 1번");
            System.out.println("택시에 승차 2번");
            int num=sc.nextInt();
            switch (num){
                case 1 :
                    start_stop = false;
                    System.out.println("택시에서 하차하였습니다.");
                    break;
                case 2:
                    start_stop = true;
                    System.out.println("택시에 승차하였습니다.");
                    System.out.println("목적지까지의 거리를 m로 입력해주세요: ");
                    this.destinationPrice=sc.nextInt();
            }// 일반상태
        }
        return this.start_stop;
    }

    public boolean Oil_check(){//주유량 검사
        if(this.oil< 10)
        {
            //주유량이 부족하면 차고지행으로 ㄱㄱ
            this.start_stop= false;
            System.out.println("주유가 필요합니다.");
            System.out.println("주유소로 들어갑니다.");
            System.out.println("주유량을 입력해주세요: ");
            this.oil=sc.nextInt();
            if(this.oil> 10) {
                this.start_stop=true;
            }System.out.println("주유량이 적어 운행을 중단합니다.");
        }
        else this.start_stop= true;//주유량이 10보다 많다면 운행중으로 변경

        return this.start_stop;
    }

    public int now_speed(){
        System.out.println("현재 속도는" +speed+"입니다.");
        System.out.println("변경하실 속도를 입력해 주세요: ");
        this.speed=sc.nextInt();
        return this.speed;
//변경하고싶은 speed값을 입력받아 속도변경
    }

    public int Distance() {//요금계산
        if (destinationPrice < basicDistance) {//목적지가 기본요금거리보다 적다
            totalfee = destinationPrice * basicfee;
        } else {//기본거리 보다 크다
            totalfee = destinationPrice * addfee;
        }
        System.out.println("총 요금은 "+ totalfee+"원 입니다.");
        return this.totalfee;
    }
}
