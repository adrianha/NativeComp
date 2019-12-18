//
//  RCTWrapper.h
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "RCTWrapperView.h"
#import "RCTWrapperViewControllerHostingView.h"
#import "RCTWrapperViewManager.h"

// Umbrella header with macros

// RCT_WRAPPER_FOR_VIEW
#define RCT_WRAPPER_FOR_VIEW(ClassName)                                        \
                                                                               \
NS_ASSUME_NONNULL_BEGIN                                                        \
                                                                               \
@interface ClassName##Manager : RCTWrapperViewManager                          \
                                                                               \
@end                                                                           \
                                                                               \
NS_ASSUME_NONNULL_END                                                          \
                                                                               \
@implementation ClassName##Manager                                             \
                                                                               \
RCT_EXPORT_MODULE()                                                            \
                                                                               \
- (UIView *)view                                                               \
{                                                                              \
  RCTWrapperView *wrapperView = [super view];                                  \
  wrapperView.contentView = [ClassName new];                                   \
  return wrapperView;                                                          \
}                                                                              \
                                                                               \
@end

// RCT_WRAPPER_FOR_VIEW_CONTROLLER
#define RCT_WRAPPER_FOR_VIEW_CONTROLLER(ClassName)                             \
                                                                               \
NS_ASSUME_NONNULL_BEGIN                                                        \
                                                                               \
@interface ClassName##Manager : RCTWrapperViewManager                          \
                                                                               \
@end                                                                           \
                                                                               \
NS_ASSUME_NONNULL_END                                                          \
                                                                               \
@implementation ClassName##Manager                                             \
                                                                               \
RCT_EXPORT_MODULE()                                                            \
                                                                               \
- (UIView *)view                                                               \
{                                                                              \
  RCTWrapperViewControllerHostingView *contentViewControllerHostingView =      \
    [RCTWrapperViewControllerHostingView new];                                 \
  contentViewControllerHostingView.contentViewController =                     \
    [[ClassName alloc] initWithNibName:nil bundle:nil];                        \
  RCTWrapperView *wrapperView = [super view];                                  \
  wrapperView.contentView = contentViewControllerHostingView;                  \
  return wrapperView;                                                          \
}                                                                              \
                                                                               \
@end
