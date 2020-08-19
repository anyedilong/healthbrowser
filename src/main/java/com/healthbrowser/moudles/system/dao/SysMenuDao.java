package com.healthbrowser.moudles.system.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.healthbrowser.moudles.common.dao.BaseDao;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.dao.repository.SysMenuRepository;
import com.healthbrowser.moudles.system.domain.SysMenu;
import com.healthbrowser.until.StringUtil;

@Named
public class SysMenuDao extends BaseDao<SysMenuRepository, SysMenu> {

	/**
	 * @Description: 获取全部的菜单树
	 * @param @param treeType
	 * @param @return
	 * @return List<SysMenu>
	 * @throws
	 */
	public List<SysMenu> getAllMenuTree() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.id, a.type, a.url, a.parent_id, a.name ");
		sql.append(" from sys_menu a");
		sql.append(" where a.status = '1' ");
		sql.append(" start with a.parent_id = '0'");
		sql.append(" connect by a.parent_id = prior a.id");
		sql.append(" order by to_number(a.order_num) ");
		return queryList(sql.toString(), null, SysMenu.class);
	}
	
	/**
	 * @Description: 管理员获取系统菜单树和居民健康菜单树(1.系统一级菜单 2.二级菜单 3.一级菜单但为外部链接)
	 * @param @param treeType
	 * @param @return
	 * @return List<SysMenu>
	 * @throws
	 */
	public List<SysMenu> getMenuTree(String treeType) {
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.id, a.type, a.url, a.parent_id, a.name");
		sql.append(" from sys_menu a");
		sql.append(" where a.status = '1' ");
		if("1".equals(treeType)) {
			sql.append("  and type in ('1', '3') ");
		}else {
			sql.append(" and type = :treeType ");
			paramMap.put("treeType", treeType);
		}
		sql.append(" start with a.parent_id = '0'");
		sql.append(" connect by a.parent_id = prior a.id");
		sql.append(" order by to_number(a.order_num) ");
		return queryList(sql.toString(), paramMap, SysMenu.class);
	}
	/**
	 * @Description: 角色获取居民健康菜单树
	 * @param @param treeType
	 * @param @return
	 * @return List<SysMenu>
	 * @throws
	 */
	public List<SysMenu> getUserMenuTree(String roleCap, String orgId) {
		Map<String, Object> paramMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.id, a.type, a.url, a.parent_id, a.name");
		sql.append(" from sys_menu a");
		sql.append(" join sys_menu_role b on a.id = b.menu_id");
		sql.append(" where a.status = '1' and a.type = '2' ");
		sql.append(" and b.org_id = :orgId ");
		//1.医生，2.护士
		if("1".equals(roleCap)) {
			//医生在健康浏览器数据中角色表中的id
			sql.append(" and b.role_id = '4b5e6803b4e64846be87534c45dddde0' ");
		}else {
			//护士在健康浏览器数据中角色表中的id
			sql.append(" and b.role_id = '4b5e6803b4e64846be87534cccdf45e0' ");
		}
		sql.append(" start with a.parent_id = '0'");
		sql.append(" connect by a.parent_id = prior a.id");
		sql.append(" order by to_number(a.order_num) ");
		paramMap.put("orgId", orgId);
		return queryList(sql.toString(), paramMap, SysMenu.class);
	}
	/**
	 * @Description: 菜单分页查询
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void queryMenuPage(SysMenu sysmenu, PageModel page) {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.id, a.name, a.url, a.status, a.order_num, a.type, a.parent_id, ");
		sql.append(" (select name from sys_menu where id = a.parent_id) as parentName ");
		sql.append(" from sys_menu a");
		sql.append(" where a.status != '3' ");
		if (!StringUtil.isNull(sysmenu.getName())) {
			sql.append(" and a.name like concat('%', concat(:name, '%')) ");
		}
		sql.append(" order by to_number(a.order_num) ");
		queryPage(sql.toString(), sysmenu, page, SysMenu.class);
	}
	/**
	 * @Description: 修改菜单的状态
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void updateMenu(String id, String status) {
		repository.updateMenu(id, status);
	}
	/**
	 * @Description: 根据id获取菜单的信息
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public SysMenu getMenuInfoById(String menuId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.id id, a.parent_id  parentId ");
		sql.append(" from sys_menu a");
		sql.append(" where a.id = :menuId ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
		return queryOne(sql.toString(), paramMap, SysMenu.class);

	}
	/**
	 * @Description: 获取当前菜单的子菜单
	 * @param @param sysmenu
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public SysMenu getFarMenuInfoByChildId(String menuId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.id id, a.parent_id  parentId ");
		sql.append(" from sys_menu a");
		sql.append(" where a.status = '1' and type = '1' ");
		sql.append(" and a.id = (select parent_id from sys_menu where id = :menuId) ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
		return queryOne(sql.toString(), paramMap, SysMenu.class);

	}
	/**
	 * @Description: 判断菜单名称是否重复
	 * @param @param name
	 * @return void
	 * @throws
	 */
	public SysMenu getMenuInfoByName(String id, String name, String orderNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.* ");
		sql.append(" from sys_menu a");
		sql.append(" where a.status = '1' ");
		sql.append(" and (a.name = :name or a.order_num = :orderNum ) ");
		if(!StringUtil.isNull(id)) {
			sql.append(" and a.id != :id ");
			paramMap.put("id", id);
		}
		paramMap.put("name", name);
		paramMap.put("orderNum", orderNum);
		return queryOne(sql.toString(), paramMap, SysMenu.class);
	}
	
}
