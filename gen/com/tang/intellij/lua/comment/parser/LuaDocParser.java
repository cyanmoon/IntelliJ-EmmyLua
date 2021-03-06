// This is a generated file. Not intended for manual editing.
package com.tang.intellij.lua.comment.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.tang.intellij.lua.comment.psi.LuaDocTypes.*;
import static com.tang.intellij.lua.psi.LuaParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LuaDocParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ACCESS_MODIFIER) {
      r = access_modifier(b, 0);
    }
    else if (t == CLASS_DEF) {
      r = class_def(b, 0);
    }
    else if (t == CLASS_NAME_REF) {
      r = class_name_ref(b, 0);
    }
    else if (t == COMMENT_STRING) {
      r = comment_string(b, 0);
    }
    else if (t == FIELD_DEF) {
      r = field_def(b, 0);
    }
    else if (t == FUNCTION_PARAM) {
      r = function_param(b, 0);
    }
    else if (t == LAN_DEF) {
      r = lan_def(b, 0);
    }
    else if (t == OVERLOAD_DEF) {
      r = overload_def(b, 0);
    }
    else if (t == PARAM_DEF) {
      r = param_def(b, 0);
    }
    else if (t == PARAM_NAME_REF) {
      r = param_name_ref(b, 0);
    }
    else if (t == RETURN_DEF) {
      r = return_def(b, 0);
    }
    else if (t == TAG_DEF) {
      r = tag_def(b, 0);
    }
    else if (t == TAG_VALUE) {
      r = tag_value(b, 0);
    }
    else if (t == TY) {
      r = ty(b, 0, -1);
    }
    else if (t == TYPE_DEF) {
      r = type_def(b, 0);
    }
    else if (t == TYPE_LIST) {
      r = type_list(b, 0);
    }
    else if (t == TYPE_SET) {
      r = type_set(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return doc(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARR_TY, FUNCTION_TY, GENERAL_TY, GENERIC_TY,
      TY),
  };

  /* ********************************************************** */
  // "protected" | "public"
  public static boolean access_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "access_modifier")) return false;
    if (!nextTokenIs(b, "<access modifier>", PROTECTED, PUBLIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESS_MODIFIER, "<access modifier>");
    r = consumeToken(b, PROTECTED);
    if (!r) r = consumeToken(b, PUBLIC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_item | STRING
  static boolean after_dash(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "after_dash")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = doc_item(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, after_dash_recover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !(DASHES)
  static boolean after_dash_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "after_dash_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, DASHES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (CLASS|MODULE) ID (EXTENDS class_name_ref)? comment_string?
  public static boolean class_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def")) return false;
    if (!nextTokenIs(b, "<class def>", CLASS, MODULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEF, "<class def>");
    r = class_def_0(b, l + 1);
    r = r && consumeToken(b, ID);
    p = r; // pin = 2
    r = r && report_error_(b, class_def_2(b, l + 1));
    r = p && class_def_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CLASS|MODULE
  private static boolean class_def_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, MODULE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXTENDS class_name_ref)?
  private static boolean class_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_2")) return false;
    class_def_2_0(b, l + 1);
    return true;
  }

  // EXTENDS class_name_ref
  private static boolean class_def_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && class_name_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment_string?
  private static boolean class_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_3")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean class_name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, CLASS_NAME_REF, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_BEGIN STRING?
  public static boolean comment_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_string")) return false;
    if (!nextTokenIs(b, STRING_BEGIN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_STRING, null);
    r = consumeToken(b, STRING_BEGIN);
    p = r; // pin = 1
    r = r && comment_string_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // STRING?
  private static boolean comment_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_string_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // (DASHES after_dash?)*
  static boolean doc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc")) return false;
    int c = current_position_(b);
    while (true) {
      if (!doc_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DASHES after_dash?
  private static boolean doc_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DASHES);
    r = r && doc_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // after_dash?
  private static boolean doc_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_0_1")) return false;
    after_dash(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '@' (param_def | return_def | class_def | field_def | type_def | lan_def | overload_def | tag_def)
  static boolean doc_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_item")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && doc_item_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // param_def | return_def | class_def | field_def | type_def | lan_def | overload_def | tag_def
  private static boolean doc_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param_def(b, l + 1);
    if (!r) r = return_def(b, l + 1);
    if (!r) r = class_def(b, l + 1);
    if (!r) r = field_def(b, l + 1);
    if (!r) r = type_def(b, l + 1);
    if (!r) r = lan_def(b, l + 1);
    if (!r) r = overload_def(b, l + 1);
    if (!r) r = tag_def(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FIELD access_modifier? ID type_set comment_string?
  public static boolean field_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_def")) return false;
    if (!nextTokenIs(b, FIELD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEF, null);
    r = consumeToken(b, FIELD);
    p = r; // pin = 1
    r = r && report_error_(b, field_def_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ID)) && r;
    r = p && report_error_(b, type_set(b, l + 1)) && r;
    r = p && field_def_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // access_modifier?
  private static boolean field_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_def_1")) return false;
    access_modifier(b, l + 1);
    return true;
  }

  // comment_string?
  private static boolean field_def_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_def_4")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID ':' type_set
  public static boolean function_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, EXTENDS);
    r = r && type_set(b, l + 1);
    exit_section_(b, m, FUNCTION_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // (function_param ',')* (function_param |& ')')
  static boolean function_param_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param_list")) return false;
    if (!nextTokenIs(b, "", RPAREN, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_param_list_0(b, l + 1);
    r = r && function_param_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (function_param ',')*
  private static boolean function_param_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param_list_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!function_param_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_param_list_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // function_param ','
  private static boolean function_param_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_param(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // function_param |& ')'
  private static boolean function_param_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_param(b, l + 1);
    if (!r) r = function_param_list_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // & ')'
  private static boolean function_param_list_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param_list_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ty ',')* ty
  static boolean generic_param_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_param_list")) return false;
    if (!nextTokenIs(b, "", ID, FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = generic_param_list_0(b, l + 1);
    r = r && ty(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ty ',')*
  private static boolean generic_param_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_param_list_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!generic_param_list_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "generic_param_list_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ty ','
  private static boolean generic_param_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_param_list_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ty(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LANGUAGE ID
  public static boolean lan_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lan_def")) return false;
    if (!nextTokenIs(b, LANGUAGE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LAN_DEF, null);
    r = consumeTokens(b, 1, LANGUAGE, ID);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // OVERLOAD function_ty
  public static boolean overload_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "overload_def")) return false;
    if (!nextTokenIs(b, OVERLOAD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OVERLOAD_DEF, null);
    r = consumeToken(b, OVERLOAD);
    p = r; // pin = 1
    r = r && function_ty(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TAG_PARAM OPTIONAL? param_name_ref type_set comment_string?
  public static boolean param_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_def")) return false;
    if (!nextTokenIs(b, TAG_PARAM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DEF, null);
    r = consumeToken(b, TAG_PARAM);
    p = r; // pin = 1
    r = r && report_error_(b, param_def_1(b, l + 1));
    r = p && report_error_(b, param_name_ref(b, l + 1)) && r;
    r = p && report_error_(b, type_set(b, l + 1)) && r;
    r = p && param_def_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // OPTIONAL?
  private static boolean param_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_def_1")) return false;
    consumeToken(b, OPTIONAL);
    return true;
  }

  // comment_string?
  private static boolean param_def_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_def_4")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean param_name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_name_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, PARAM_NAME_REF, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_RETURN type_list comment_string?
  public static boolean return_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_def")) return false;
    if (!nextTokenIs(b, TAG_RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_DEF, null);
    r = consumeToken(b, TAG_RETURN);
    p = r; // pin = 1
    r = r && report_error_(b, type_list(b, l + 1));
    r = p && return_def_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // comment_string?
  private static boolean return_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_def_2")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TAG_NAME tag_value? comment_string?
  public static boolean tag_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_def")) return false;
    if (!nextTokenIs(b, TAG_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TAG_DEF, null);
    r = consumeToken(b, TAG_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, tag_def_1(b, l + 1));
    r = p && tag_def_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // tag_value?
  private static boolean tag_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_def_1")) return false;
    tag_value(b, l + 1);
    return true;
  }

  // comment_string?
  private static boolean tag_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_def_2")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean tag_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_value")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, TAG_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE type_set comment_string?
  public static boolean type_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_def")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DEF, null);
    r = consumeToken(b, TYPE);
    p = r; // pin = 1
    r = r && report_error_(b, type_set(b, l + 1));
    r = p && type_def_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // comment_string?
  private static boolean type_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_def_2")) return false;
    comment_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // type_set(',' type_set)*
  public static boolean type_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list")) return false;
    if (!nextTokenIs(b, "<type list>", ID, FUN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LIST, "<type list>");
    r = type_set(b, l + 1);
    r = r && type_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' type_set)*
  private static boolean type_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!type_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' type_set
  private static boolean type_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_set(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ty ('|' ty)*
  public static boolean type_set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_set")) return false;
    if (!nextTokenIs(b, "<type set>", ID, FUN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_SET, "<type set>");
    r = ty(b, l + 1, -1);
    r = r && type_set_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('|' ty)*
  private static boolean type_set_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_set_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!type_set_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_set_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '|' ty
  private static boolean type_set_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_set_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && ty(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: ty
  // Operator priority table:
  // 0: ATOM(function_ty)
  // 1: POSTFIX(generic_ty)
  // 2: POSTFIX(arr_ty)
  // 3: ATOM(general_ty)
  public static boolean ty(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "ty")) return false;
    addVariant(b, "<ty>");
    if (!nextTokenIs(b, "<ty>", ID, FUN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<ty>");
    r = function_ty(b, l + 1);
    if (!r) r = general_ty(b, l + 1);
    p = r;
    r = r && ty_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean ty_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "ty_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && generic_ty_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, GENERIC_TY, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, ARR)) {
        r = true;
        exit_section_(b, l, m, ARR_TY, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // fun '(' function_param_list ')' (':' type_set)?
  public static boolean function_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_ty")) return false;
    if (!nextTokenIsSmart(b, FUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, FUN, LPAREN);
    r = r && function_param_list(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && function_ty_4(b, l + 1);
    exit_section_(b, m, FUNCTION_TY, r);
    return r;
  }

  // (':' type_set)?
  private static boolean function_ty_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_ty_4")) return false;
    function_ty_4_0(b, l + 1);
    return true;
  }

  // ':' type_set
  private static boolean function_ty_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_ty_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, EXTENDS);
    r = r && type_set(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' generic_param_list '>'
  private static boolean generic_ty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_ty_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LT);
    r = r && generic_param_list(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // class_name_ref
  public static boolean general_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "general_ty")) return false;
    if (!nextTokenIsSmart(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_name_ref(b, l + 1);
    exit_section_(b, m, GENERAL_TY, r);
    return r;
  }

  final static Parser after_dash_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return after_dash_recover(b, l + 1);
    }
  };
}
