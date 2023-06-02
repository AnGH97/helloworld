package study.spring.project1.services;

import java.util.List;

import study.spring.project1.models.ProductModel;

/** 
 * 상품 관리 기능과 관련된 Mabatis Mapper를 간접적으로 호출하기 위한 기능 명세
 * 하나의 처리를 위해서 두 개 이상의 기능을 연동할 필요가 있을 경우,
 * 이 인터페이스의 구현체(Impl)을 통해서 처리한다.
 */
public interface ProductService {

    /**
     * 상품 정보를 새로 저장하고 저장된 정보를 조회하여 리턴한다.
     * 저장된 행의 수가 0이거나, SQL에 에러가 있는 경우는
     * 예외를 발생시켜서, 이 메서드를 호출하는 위치에서 try~catch
     * 구문을 강제적으로 사용하도록 throws를 명시한다.
     * 
     * @param input - 저장될 정보를 담고 있는 Beans
     * @return  - 저장된 데이터
     * @throws NullPointerException - 저장된 데이터가 없는 경우
     * @throws Exception            - SQL 처리에 실패한 경우
     */
    public ProductModel insert(ProductModel input) throws NullPointerException, Exception;

    /**
     * 상품 정보를 수정하고, 수정된 정보를 조회하여 리턴한다.
     * 수정 후 영향을 받은 행 수가 없거나, SQL에 에러가 있는 경우는
     * 예외를 발생시켜서, 이 메서드를 호출하는 위치에서 try~catch
     * 구문을 강제적으로 사용하도록 throws를 명시한다.
     * 
     * @param params - 수정될 정보를 담고 있는 Beans
     * @return - 수정된 데이터
     * @throws NullPointerException - 수정된 데이터가 없는 경우
     * @throws Exception            - SQL처리에 실패한 경우
     */
    public ProductModel update(ProductModel input) throws NullPointerException, Exception;

    /**
     * 상품 정보를 삭제한다.
     * 삭제 후 상품 테이블에서 영향을 받은 행 수가 없거나,
     * SQL에 에러가 있는 경우는 예외를 발생시켜서
     * 이 메서드를 호출하는 위치에서 try~catch 구문을 강제적으로
     * 사용하도록 throws를 명시한다.
     * 
     * @param params - 삭제될 상품의 정보를 담고 있는 Beans
     * @return - Void
     * @throws NullPointerException - 삭제된 데이터가 없는 경우
     * @throws Exception            - SQL처리에 실패한 경우
     */
    public void delete(ProductModel input) throws NullPointerException, Exception;

    /**
     * 상품 하나의 정보를 조회하여 리턴한다.
     * 
     * @param params - 조회할 대상의 정보를 담고 있는 Beans
     * @return - 조회결과를 담고 있는 Beans
     * @throws NullPointerException - 조회된 데이터가 없는 경우
     * @throws Exception            - SQL처리에 실패한 경우
     */
    public ProductModel selectItem(ProductModel input) throws NullPointerException, Exception;

    /**
     * 상품 목록을 조회하여 리턴한다.
     * 
     * @param params - 검색이 필요한 경우 검색어를 저장하고 있는 beans
     * @return - 조회 결과를 담고 있는 컬렉션
     * @throws NullPointerException - 조회된 데이터가 없는 경우
     * @throws Exception            - SQL처리에 실패한 경우
     */
    public List<ProductModel> selectList(ProductModel input) throws NullPointerException, Exception;

    public int selectCount(ProductModel input) throws NullPointerException, Exception;


    /**
     * best 상품 노출 + 높은 가격순, 낮은 가격순 정렬이 가능하도록 만듬.
     * @param input
     * @return
     * @throws NullPointerException
     * @throws Exception
     */
    public List<ProductModel> selectBestList(ProductModel input) throws NullPointerException, Exception;
    
    /**
     * 상품 상세 페이지에서 가져올 상품 관련 내용과 이미지를 리턴한다.
     * 
     * @param input
     * @return
     * @throws NullPointerException
     * @throws Exception
     */
    public List<ProductModel> selectProductDetailList(ProductModel input) throws NullPointerException, Exception;


    /**
     * 어떤 Category1 상품 전체 페이지에서 thumbnail사진만 갖고오도록 하는 SQL
     * 
     * @param input
     * @return
     * @throws NullPointerException
     * @throws Exception
     */
    public List<ProductModel> selectItemImg(ProductModel input) throws NullPointerException, Exception;

    /**
     * 검색 결과에 맞는 상품의 정보 + 이미지 select
     * @param input
     * @return
     * @throws NullPointerException
     * @throws Exception
     */
    public List<ProductModel> selectListImg(ProductModel input) throws NullPointerException, Exception;

    
}
