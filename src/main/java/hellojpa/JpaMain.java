package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // emf 는 애플리케이션 로딩 시점에 딱 1개만 만들어둬야 함
        EntityManager em = emf.createEntityManager();
        // 실제 디비에 저장하거나 하는 트랜잭션 단위의 작업을 할 때마다 em을 만들어 줘야 함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("helloJPA");
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close(); // entityManager 가 데이터베이스 커넥션을 물고 동작
        }
        emf.close();
        // 데이터를 변경하는 모든 작업은 트랜잭션 내에서 이루어져야 함 - jpa
    }
}
