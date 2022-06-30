import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bus {

    int bus_num;//버스 번호
    int fee;//요금
    boolean start_stop;//차고지 운행
    int oil;//오일
    int speed;//속도
    int max_passenger;//최대인원
    int passenger;//현재 인원
    Scanner sc = new Scanner(System.in);

}

class new_bus extends bus {
    List<Integer> buslist = new ArrayList<>();

    boolean bus_num_heck(int busnum) {
        for (int i = 0; i < buslist.size(); i++) {
            if (busnum == buslist.get(i)) {
                System.out.println("버스번호가 중복됩니다. ");
                System.out.println("-----다른 번호로 등록해주세요.-----");
                return false;
            }
        }
        buslist.add(busnum);
        return true;
    }

    new_bus(int bus_num, int fee, boolean start_stop, int oil, int speed, int max_passenger, int passenger) {
        this.bus_num = bus_num;
        this.fee = fee;
        this.start_stop = true;//true: 운행
        this.oil = oil;
        this.speed = speed;
       this.max_passenger = max_passenger;
        this.passenger=0;


        System.out.println("생성할 버스 번호를 입력해주세요: ");
        bus_num=sc.nextInt();

        if(!bus_num_heck(bus_num)){
           this.bus_num=sc.nextInt();
        }
        else{
            System.out.println("버스 요금을 입력해주세요: ");
            this.fee=sc.nextInt();
            System.out.println("버스 최대 인원수를 입력해주세요: ");
            this.max_passenger=sc.nextInt();
            System.out.println("버스의 오일을 입력해주세요: ");
            this.oil=sc.nextInt();
            System.out.println("버스의 최고 속도를 입력해주세요: ");
            this.speed=sc.nextInt();
            System.out.println("버스" + bus_num + "번이 생성 되었습니다.");}
    }


    public int passenger(){//승객 태우기
        if(this.start_stop==true){
            int minus_passenger=0;//하차할 손님 수
            System.out.println("현재 버스에 탑승한 인원: "+passenger);
            if(passenger>0){
            System.out.print("하차할 손님 수를 입력: ");
            minus_passenger=sc.nextInt();
            this.passenger=-minus_passenger;
            }
            System.out.print("탑승 손님 수를 입력: ");
            this.passenger=sc.nextInt();
            if(this.passenger<=max_passenger){
                this.passenger+=passenger;
                System.out.println("탑승하였습니다.");
            }else {
                System.out.println("인원이 초과되어 탑승에 실패하였습니다.");
            }
        }else{
            System.out.println("차량이 차고지행에 들어가 있는 상태입니다!");
            System.out.println("---------------------");
        }
        return this.passenger;
    }

    public void Oil_check(){//주유량 검사
        if(this.oil< 10)
        {
            //주유량이 부족하면 차고지행으로 ㄱㄱ
            this.start_stop= false;
            System.out.println("주유가 필요합니다.");
            System.out.println("차고지행으로 들어갑니다.");
            System.out.println("주유량을 입력해주세요: ");
            this.oil=sc.nextInt();
            if(this.oil> 10) {
                this.start_stop=true;
            }System.out.println("주유량이 적어 운행을 중단합니다.");
        }
        else this.start_stop= true;//주유량이 10보다 많다면 운행중으로 변경

    }

    public void now_speed(){
        System.out.println("현재 속도는" +speed+"입니다.");
        System.out.println("변경하실 속도를 입력해 주세요: ");
        this.speed=sc.nextInt();
//변경하고싶은 speed값을 입력받아 속도변경
    }
}
//메인 함수 만들,,,??